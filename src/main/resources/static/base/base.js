var token = localStorage.getItem("token");
console.log(token);
if(token != null && token != ''){
    $(function(){
        $.ajax({
                   type : "post",
                   url : "/userC/validateUserLogin",
                   data : "token="+token,
                   success : function(data) {
                       //console.log(vm.parent.success);
                       //console.log(vm.isTest);
                       if(data.success != true){
                           location.href = "../login.html";
                       }
                   },
                   error : function() {
                       console.log("请求失败");
                   }
               });
    });

}else{
    location.href="../login.html";
}
