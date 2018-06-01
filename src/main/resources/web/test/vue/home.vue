
    // Home.vue
    <script>
    export default {
        name: 'home',
        data () {
            return {
                home: '别看了这里啥也没有'
            }
        },
        computed: {
            username () {
                // 我们很快就会看到 `params` 是什么
                return this.$route.params.username
            }
        },
        methods: {
            goBack () {
                window.history.length > 1
                    ? this.$router.go(-1)
                    : this.$router.push('/')
            }
        }
    }
    </script>