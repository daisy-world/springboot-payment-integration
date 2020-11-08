   <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
            PAYMENT GATEWAY
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
              <li><a href="#"><span class="glyphicon glyphicon-user">
              
              </span>&nbsp; ${sessionScope.name}</a></li>         
         
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
              
                <li>
                    <a href="${pageContext.request.contextPath}/dashboard"><i class="fas fa-tachometer-alt"></i></i>&nbsp;<b>Dashboard</b></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/users"><i class="fas fa-user"></i>&nbsp;&nbsp;<b>Users</b></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/payment"><i class="fa fa-credit-card"></i>&nbsp;<b>Payment</b></a>
                </li>
               <li><a href="${pageContext.request.contextPath}/changePassword"><i class="fa fa-key"></i> <b>Change Password</b></a></li>
               <li><a href="${pageContext.request.contextPath}/logout"><i class="fas fa-sign-out-alt"></i> <b>Logout</b></a></li>
                
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>