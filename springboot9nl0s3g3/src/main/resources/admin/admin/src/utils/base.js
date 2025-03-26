const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot9nl0s3g3/",
            name: "springboot9nl0s3g3",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot9nl0s3g3/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于springboot的商场多功能折扣系统"
        } 
    }
}
export default base
