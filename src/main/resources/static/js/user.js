let index={
    init: function(){
        $("#btn-save").on("click", ()=>{
            this.save();
        });
    },

    save: function(){
//        alert("회원가입 완료.");
        let data={
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }

//        console.log(data);

        //통신을 통해 파라미터를 넘김.
        $.ajax().done().fail();
    }
}

index.init();