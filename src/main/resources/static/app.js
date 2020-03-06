var stompClient = null;

function setConnected(connected) {
    $("#connectStatus").html(connected ? "Connected" : "Disconnected");
}

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function (message) {
            console.log(message);
            showMessage(JSON.parse(message.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showMessage(message) {
    console.log(message);
    $("#messages").append("<tr><td>"+ message.createdAt +"</td><td>" + message.message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

$( document ).ready(function() {
    setConnected(false);
    $.get( "/api/v1/message/list", function( messages ) {
        console.log(messages);
        $.each(messages, function(_, message) {
            console.log(message);
            showMessage(message);
        });
        connect();
    });
});