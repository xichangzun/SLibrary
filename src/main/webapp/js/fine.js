/**
 * Created by root on 16-11-12.
 */
$(function () {
    $.ajaxSetup({
        async: false
    });
    $('#process_fine button').click(function () {
        var json = {
            "id":$("#user_id").html()
        }
       $.get("/Fine/update",json,function (message) {
            alert(message);
       });
        $('#process_fine').hide();
        $('#query_fine').show();
        return false;
    });
    $('#query_fine button').click(function(event) {
        $('#query_fine').hide();
        var json = {
            "id":$('#query_fine input').val()
        };
        $.get("/Fine/query",json,function (message) {
            $("#fine").html(message);
        });
        $('#process_fine').show().find('#user_id').html($('#query_fine input').val());

    });

})
