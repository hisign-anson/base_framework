/**
 * Created by evans on 16/12/27.
 */
$.fn.fullPanel=function(ctrlSelector){
    var wrap=top.$(window.frameElement);//top.$('#main-wrap');
    var topBody=top.$('body');
    this.each(function(index,el){
        var the = $(el);
        var ctrlSelector=ctrlSelector||'>div .full-ctrl-btn';
        var ctrl=the.find(ctrlSelector);
        ctrl.click(function(){
            if(the.hasClass('full-panel')){
                the.siblings().add(the.parent().siblings()).addClass('hidden');

                topBody.animate({opacity:0},10,function () {
                    //避免引发重绘
                    window._cancelGlobalReFixTbTime=new Date().getTime();
                    $('body').removeClass('full-mode-ovh');
                    topBody.removeClass('full-mode-ovh');
                    wrap.removeClass('full-panel-wrap');
                    //引发重绘
                    window._cancelGlobalReFixTbTime=new Date().getTime()-500;
                    the.removeClass('full-panel');
                    setTimeout(function(){
                        topBody.animate({opacity:1},60);
                        the.siblings().add(the.parent().siblings()).removeClass('hidden');
                    },200);
                });

                ctrl[0] && (ctrl[0].title='最大化显示') && ctrl.removeClass('icon-resize-small').addClass('icon-resize-full');
            }else{
                the.siblings().add(the.parent().siblings()).addClass('hidden');
                topBody.animate({opacity:0},10,function () {
                    //避免引发重绘
                    window._cancelGlobalReFixTbTime=new Date().getTime();
                    $('body').addClass('full-mode-ovh');
                    topBody.addClass('full-mode-ovh');
                    wrap.addClass('full-panel-wrap');
                    the.addClass('full-panel');
                    //引发重绘
                    window._cancelGlobalReFixTbTime=new Date().getTime()-500;
                    setTimeout(function(){
                        topBody.animate({opacity:1},60);
                    },260);
                });


                ctrl[0] && (ctrl[0].title='还原') && ctrl.removeClass('icon-resize-full').addClass('icon-resize-small');
            }
        });
    });
    return this;
};