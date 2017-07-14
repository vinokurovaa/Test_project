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
            jVal.sendIt();
        });
        return false;
    });
    $('#fullname').change(jVal.fullName);
});
