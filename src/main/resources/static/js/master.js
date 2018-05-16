//Vue.config.devtools = true

const index = {
    template: '<div><h1>主页</h1></div>'
}

const routes = [
    {
        path: '/',
        component: index,
    },
    {
        path: '/about',
        component: {
            template: `
            <div>
                <h1>关于我</h1>
            </div>
            `,
        },
    },
]

var router = new VueRouter({
    routes: routes,
});

new Vue({
    el: '#master',
    router: router,
});