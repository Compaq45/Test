var TaskApi = Vue.resource('/Tasks{/id}');

Vue.component('Task-row', {
    props: ['task'],
    template: '<div class="task-list-element">' +
        '<div class="task-name">{{ task.task_name }}</div>' +
        '<div class="task-creator">{{ task.task_creator.first_name }} {{ task.task_creator.second_name }} {{ task.task_creator.family_name }}</div>' +
        '<div class="task-timestamp">{{ task.filling_time }}</div></div>'
});

Vue.component('Task-list', {
    props: ['Tasks'],
    template: '<div><Task-row v-for="task in Tasks" :key="task.id" :task="task" /></div>',
    created: function() {
        TaskApi.get().then(result =>
            result.json().then(data =>
                data.forEach(task => this.Tasks.push(task))
            )
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<Task-list :Tasks="Tasks" />',
    data: {
        Tasks: []
    }
})