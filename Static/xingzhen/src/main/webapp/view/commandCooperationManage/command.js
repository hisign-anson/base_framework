/**
 * Created by dell on 2017/9/28.
 */

$.ajaxSetup({
    beforeSend:showLoading,
    complete:hideLoading
});
require(['src/commandCooperation.js'],function(commandCooperation){
    commandCooperation.showList();
});