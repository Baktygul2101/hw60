<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lesson 61. Javascript 101</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body class="no-scroll">
<div class="container">
    <div class="row justify-content-center">

        <div class="col col-lg-7 posts-container">
            <!-- single post start -->

            <form id="form" name="form" enctype="multipart/form-data" action="/post" method="post">
                <input type="text" placeholder="description" name="name" id="name">
                <input type="file" name="photo" id="photo">
                <button type="button" id="save-candidate">Save</button>
            </form>

            <div class="card my-3">
                <!-- image block start -->
                <div class="photo-post">
                    <img class=" w-100" src="http://placekitten.com/500/500" alt="Post image">

                </div>
                <!-- image block end -->
                <div class="px-4 py-3">

                    <!-- post reactions block start -->
                    <div class="d-flex justify-content-around">

                        <span id='heart' onclick='toggleHurt()'>
                          <i class="far fa-heart h1 mx-2 muted"></i>
                        </span>


                        <span id="cmn" class="h1 mx-2 muted" onclick="toggleComment()" >
                          <i class="far fa-comment"></i>
                        </span>
                        <span class="mx-auto"></span>


                        <span id="publ"  onclick="togglePost()" class="h1 mx-3 muted">
                          <i class="far fa-bookmark"></i>
                        </span>
                        <!--   <span class="h1 mx-2 muted">
                            <i class="fas fa-bookmark"></i>
                          </span>-->
                    </div>
                    <!-- post reactions block end -->
                    <hr>
                    <!-- post section start -->

                    <div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid corrupti nesciunt, obcaecati fuga natus officiis.</p>

                    </div>
                    <!-- post section end -->
                    <hr>
                    <!-- comments section start -->


                    <div class="py-2 pl-3">

                        <!--   <input type="text"size='20' name="text"/>
                           <button onClick='createCommentElement()'>Add comment</button>-->
                        <div class="py-2 pl-3">
                            <a href="#" class="muted">someusername</a>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid corrupti nesciunt, obcaecati fuga natus officiis.</p>
                        </div>
                        <div class="py-2 pl-3">
                            <a href="#" class="muted">someusername</a>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum ad est cumque nulla voluptatem enim voluptas minima illum quis! Voluptatibus dolorem minus tempore aliquid corrupti nesciunt, obcaecati fuga natus officiis.</p>
                        </div>
                        <p id="link" onclick="showForm()">Добавить комментарий</p>
                        <form id="comm" hidden>
                            <input type="text"size='20' name="text"/>
                            <button onClick='createCommentElement()'>Add comment</button>
                        </form>
                    </div>
                    <!-- comments section end -->
                </div>

            </div>
            <!-- single post end -->
        </div>
    </div>
</div>
<!-- Splash screen -->
<section id="page-splash" class="page-splash">
    <div class="card" id="registration-form">
        <div class="card-body">
            <button class="bt">Войти</button>
            <h3 class="h3">Зарегистрируйтесь</h3>
        </div>
    </div>
</section>
</body>
</html>

<script src="/js/script.js"></script>