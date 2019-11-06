$(document).ready(function(){
    $(".spot").on("click", function(){
        $(this).next().stop().slideToggle();
        $(this).parent().siblings().children("ul").slideUp();
    });
    $(".Modal-submission").click(function(){
        var htm="";
        htm +="<div class='col-sm-3 col-md-3 col-xs-6' th:each=\'user : ${session.users}\'>";
        htm +="<div class='card-c'>";
        htm +="<div class='blue'>";
        htm +="<div class='text-left gg'>GG</div>";
        htm +="<div class='spot1'>...</div>";
        htm +="<ul class='two_bar1'>";
        htm +="<p class='triangle'></p>";
        htm +="<li><button onclick=\'see()\'>查看</button></li>";
        htm +="<li><button data-toggle=\"modal\" data-target=\"#myModal_2\">修改</button></li>";
        htm +="<li><button onclick=\'del()\'>删除</button></li></ul>";
        htm +="<p class='text-right'></p>";
        htm +="<p class='text-center card1' th:text=\'${user.name}\'>翁少锋</p>";
        htm +="<p class='text-center card2' th:text=\'${user.deptId}\'>电商运营部</p></div>";
        htm +="<div class='card-img'><img th:src=\'@{${user.img}}\' class='center-block'></div>";
        htm +="<p class='text-center card3' th:text=\'${user.userpost}\'>UI设计师</p>";
        htm +="<p class='text-center card4' th:text=\'${user.createTime}\'>入职设计：2018.07.05</p></div></div>";
        $('.add-personnel').append(htm);
        $(".spot1").on("click", function(){
            $(this).next().stop().slideToggle();
            $(this).parent().siblings().children("ul").slideUp();
        });
    });
});