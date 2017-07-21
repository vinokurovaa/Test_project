$(document).ready(function () {
    var jVal = {
        'fullName' : function () {
            $('body').append('<div id="nameInfo" class="info"></div>');
            var nameInfo = $('#nameInfo');
            var ele = $('#fullname');
            var pos = ele.offset();

            nameInfo.css({
               top: pos.top-3,
               left: pos.left+ele.width()+15
            });
            if(ele.val().length < 3) {
                jVal.errors = true;
                    nameInfo.removeClass('correct').addClass('error').html('← at least 6 characters').show();
                    ele.removeClass('normal').addClass('wrong');
            }else {
                nameInfo.removeClass('error').addClass('correct').html('√').show();
                ele.removeClass('wrong').addClass('normal');
            }
        },
        'email' : function () {
            $('body').append('<div id="emailInfo" class="info"></div>');
            var emailInfo = $('#emailInfo');
            var element = $('#email');
            var pos = element.offset();

            emailInfo.css({
               top: pos.top-3,
               left: pos.left+element.width()+15
            });
            var patt = /^.+@.+[.].{2,}$/i;
            if(!patt.test(element.val())){
                jVal.errors = true;
                emailInfo.removeClass('correct').addClass('error').html('<- Email address is not correct').show();
                element.removeClass('normal').addClass('wrong');
            }else {
                emailInfo.removeClass('error').addClass('correct').html('√').show();
                element.removeClass('wrong').addClass('normal');
            }
        },
        'checkEmail' : function () {
            var emailInfo = $('#emailInfo');
            var element = $('#email');
            var email = element.val();
            var jSON = {
                email : email
            };
            var flag;
            $.ajax({
                type: "POST",
                contentType : "application/json",
                url : "/checkEmail",
                data : JSON.stringify(jSON),
                dataType : 'json',
                async: false,
                success : function (result) {
                    flag = result;
                    if(!result){
                        jVal.errors = true;
                        emailInfo.removeClass('correct').addClass('error').html('<- Email address is not unique').show();
                        element.removeClass('normal').addClass('wrong');
                    }else{
                        emailInfo.removeClass('error').addClass('correct').html('√').show();
                        element.removeClass('wrong').addClass('normal');
                    }
                },
                error: function(e){
                    console.log("ERROR: ", e);
                    displayUsernamError(e);
                },
            });
            return flag;
        },
        'sendIt' : function (){
            if(!jVal.errors) {
                $('#jform').submit();
            }
        }
    };
    $('#send').click(function () {
        var obj = $.browser.webkit ? $('body') : $('html');
        obj.animate({ scrollTop: $('#jform').offset().top }, 750, function () {
            jVal.errors = false;
            jVal.fullName();
            jVal.email();
            jVal.checkEmail();
            jVal.sendIt();
        });
        return false;
    });
    $('#fullname').change(jVal.fullName);
    $('#email').change(jVal.email);
    $('#email').change(jVal.checkEmail);

});
