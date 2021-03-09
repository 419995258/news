/**
 * Created by pb on 2018/5/31.
 */



// 0. 如果使用模块化机制编程，导入Vue和VueRouter，要调用 Vue.use(VueRouter)
    // 1. 定义 (路由) 组件。
    // 可以从其他文件 import 进来
const Foo = {template: '<div>foo???</div>'}
const Bar = {template: '<div>bar</div>'}
const home = {}

// 2. 定义路由
// 每个路由应该映射一个组件。 其中"component" 可以是
// 通过 Vue.extend() 创建的组件构造器，
// 或者，只是一个组件配置对象。
// 我们晚点再讨论嵌套路由。
const routes = [
    {path: '/foo', component: Foo},
    {path: '/bar', component: Bar},
    {
        path: '/',
        name: 'home',
        component: home
    },
    {
        path: '/home',
        name: 'home',
        component: home
    },

    /*,
    {
        path: '/page01',
        name: 'page01',
        component: page01,
        children: [
            {
                path: 'page01-a',
                name: 'page01A',
                component: page01A
            },
            {
                path: 'page01-b',
                name: 'page01B',
                component: page01B,
                children: [
                    {
                        path: 'end',
                        name: 'pageEnd',
                        component: pageEnd
                    }
                ]
            }
        ]
    },
    {
        path: '/page02',
        name: 'page02',
        component: page02
    }*/
]

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
const router = new VueRouter({
                                 routes: routes// (缩写) 相当于 routes: routes
                             })

// 现在，应用已经启动了！
