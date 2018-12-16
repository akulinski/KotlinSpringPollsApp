<!DOCTYPE html>
<html lang="en">
<head>

    <base href="/">
    <meta charset="UTF-8">
    <title>All pools</title>
</head>
<body class="background">

<#include "navbar.ftl">

<div class="container">


    <div class="row">
<#list pools as pool>

    <div class="col-sm">


        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${pool.getId()}</h5>
                <h6 class="card-subtitle mb-2 text-muted">Created by: ${pool.getUserEntity().getUsername()}</h6>
                <p class="card-text">${pool.getTitle()}</p>
                <a href="../pools/pool/${pool.getId()}" class="card-link">Go to pool</a>
            </div>
        </div>


    </div>
</#list>
    </div>


</div>


<script src="/webjars/bootstrap/4.1.3/js/bootstrap.js"></script>

<link rel="stylesheet"
      href="/webjars/bootstrap/4.1.3/css/bootstrap.css"/>
<link rel="stylesheet" href="/webjars/bootstrap-glyphicons/bdd2cbfba0/css/bootstrap-glyphicons.css"/>

<script src="/webjars/jquery/3.3.1-1/jquery.js"></script>

<link rel="stylesheet" href="/css/customstyle.css">

</body>
</html>