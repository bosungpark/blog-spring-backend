let index={
    init: function(){
        $("#btn-save").on("click", ()=>{
            this.save();
        });

//        $("#btn-login").on("click", ()=>{
//            this.login();
//        });
    },

    save: function(){
//        alert("회원가입 완료.");
        let data={
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        console.log(data);
        //통신을 통해 파라미터를 넘김. default가 비동기 호출
        //ajax통신에 성공시, 서버가 자동으로 dataType: "json"으로 변환
        $.ajax({
            type: "POST",
            url:"/auth/joinProc",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",//body 데이터의 타입 명시
//            dataType: "json"//요청에 대한 응답의 데이터 타입 명시
            beforeSend: function (jqXHR, settings) {
                       var header = $("meta[name='_csrf_header']").attr("content");
                       var token = $("meta[name='_csrf']").attr("content");
                       jqXHR.setRequestHeader(header, token);
            	}
        //정상 수행 시
        }).done(function(resp){
            alert("회원가입이 완료되었습니다.");
//            console.log(resp)
            location.href="/";
        //실패 시
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

//    login: function(){
//            let data={
//                username: $("#username").val(),
//                password: $("#password").val(),
//            };
//
//            $.ajax({
//                type: "POST",
//                url:"/api/user/login",
//                data: JSON.stringify(data),
//                contentType: "application/json; charset=utf-8",//body 데이터의 타입 명시
//                beforeSend: function (jqXHR, settings) {
//                                       var header = $("meta[name='_csrf_header']").attr("content");
//                                       var token = $("meta[name='_csrf']").attr("content");
//                                       jqXHR.setRequestHeader(header, token);
//                            	}
//            }).done(function(resp){
//                alert("로그인이 완료되었습니다.");
//                //로그인 완료시 /로 매핑
//                location.href="/";
//            }).fail(function(error){
//                alert(JSON.stringify(error));
//            });
//    }
}

index.init();