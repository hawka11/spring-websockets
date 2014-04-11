<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="js/sockjs-0.3.js"></script>
    <script type="text/javascript" src="js/sockjs-0.3.js"></script>
    <script type="text/javascript" src="js/stomp.js"></script>
</head>
<body>
<h1>Websockets</h1>

<button class="disconnect">Disconnect</button>

<script type="text/javascript">
    var socket = new SockJS("/app/rest/portfolio", null, {
        //'protocols_whitelist': ['xdr-polling', 'xhr-polling', 'iframe-xhr-polling', 'jsonp-polling']
    });
    var stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        stompClient.subscribe("/topic/greeting", function (msg) {
            $(document.body).append("topic: " + msg.body + "<br/>");
        });

        stompClient.subscribe("/user/mekeith/userspecificqueue", function (msg) {
            $(document.body).append("user: " + msg.body + "<br/>");
        });

        stompClient.send("/app/greeting", {}, "Hello, STOMP");

        $(".disconnect").click(function () {
            stompClient.disconnect();
        });
    });

    $(window).on("beforeunload", function(e) {
        stompClient.disconnect();
    });
    /*$(window).on("beforeunload", function(e) {
        return 'Dialog text here.';
    });*/

    /*window.onbeforeunload = function(e) {
        stompClient.disconnect();
        return 'Dialog text here.';
    };*/
</script>
</body>
</html>