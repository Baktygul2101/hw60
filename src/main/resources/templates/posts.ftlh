<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>My posts</title>
    <link rel="stylesheet" href="/css/candidates.css">
   </head>

<body>
<div class="col col-lg-4 posts-container">
    <div class="container flex flex-col align-center">
<h1>My posts</h1>
      <main class="flex flex-wrap align-evenly" id="candidate-list">
        <#list posts as post>
        <div class="card ">
          <form action="/like" method="post" class="flex flex-col align-center">
            <img src="/image/${post.photo}"  width="350" height="270">
            <p>${post.name}</p>
             <input name="candidateId" type="hidden" value="${post.id}">

          </form>

        </div>
    </div>
        </#list>
      </main>

    </div>
</body>
<script src="/js/script.js"></script>
</html>