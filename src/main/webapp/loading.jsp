<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style>
            .bar{
                width:1200px;
                height:20px;
                background-color:black;
                position:relative;
            }
            .child{
                position: absolute;
                top:0px;
                left:0px;
                background-color:red;
                height:20px;
            }
            .clr{
                width:100%;
                height:2px;    
            }
        </style>
        <script>
            var pbArr = [{
                    pid: 'bar1', // parent container id
                    incr: <c:out value="${ sessionScope.speeds[0] }"/> // increment value
                }, {
                    pid: 'bar2',
                    incr: <c:out value="${ sessionScope.speeds[1] }"/>
                }, {
                    pid: 'bar3',
                    incr: <c:out value="${ sessionScope.speeds[2] }"/>
                }, {
                    pid: 'bar4',
                    incr: <c:out value="${ sessionScope.speeds[3] }"/>
                }, {
                    pid: 'bar5',
                    incr: <c:out value="${ sessionScope.speeds[4] }"/>
                }];

            var loopCnt = 1; // loop count to maintain width
            var pb_timeout; // progress bar timeout function

            // create progress bar funtion

            var createPB = function () {


                var is_all_pb_complete = true; // flag to check whether all progress bar are completed executed

                for (var i = 0; i < pbArr.length; i++) {
                    var childDiv = document.querySelector('#' + pbArr[i].pid + ' div'); // child div
                    var newWidth = loopCnt * pbArr[i].incr; // new width
                    if (newWidth <= 100) {
                        is_all_pb_complete = false;
                        childDiv.style.width = newWidth / <c:out value="${ sessionScope.scale }"/> + '%';
                    } else {
                        childDiv.style.width = '100%';
                    }
                }

                if (is_all_pb_complete) { // if true, then clear timeout
                    clearTimeout(pb_timeout);
                    return;
                }

                loopCnt++; // increment loop count

                // recall function
                pb_timeout = setTimeout(function () {
                    createPB();
                }, 1000);
            }

            // call function to initiate progress bars
            createPB();
        </script>
    </head>
    <body onload="createPB();">
        <div class="bar" id="bar1"><div class="child" style="left: <c:out value="${ sessionScope.positions[0] * 20 }"/>px;" ></div></div>
        <div class="clr"></div>
        <div class="bar" id="bar2"><div class="child" style="left: <c:out value="${ sessionScope.positions[1] * 20 }"/>px;" ></div></div>
        <div class="clr"></div>
        <div class="bar" id="bar3"><div class="child" style="left: <c:out value="${ sessionScope.positions[2] * 20 }"/>px;" ></div></div>
        <div class="clr"></div>
        <div class="bar" id="bar4"><div class="child" style="left: <c:out value="${ sessionScope.positions[3] * 20 }"/>px;" ></div></div>
        <div class="clr"></div>
        <div class="bar" id="bar5"><div class="child" style="left: <c:out value="${ sessionScope.positions[4] * 20 }"/>px;" ></div></div>

    </body>
</html>

