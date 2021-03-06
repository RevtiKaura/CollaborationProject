app.controller('BlogDetailController',function($scope,$location,BlogService,$routeParams){
	var id=$routeParams.id;
	$scope.blogPost={body:'',blogPost:{}}
	$scope.blogPost=BlogService.getBlogPostById(id)
	.then(function(response){
		$scope.blogPosts=response.data
	},function(response){
		console.log(response.status)
	})
	$scope.addBlogComment=function(){
		$scope.blogComment.blogPost=$scope.blogPost;
		BlogService.addBlogComment($scope.blogComment)
		.then(function(response){
			console.log(response.status);
			$scope.blogComment.body=''
		},function(response){
			console.log(response.status)
		})
	}
	$scope.getBlogComments=function(blogPostId){
		$scope.showcomments=true;
		$scope.blogComments=BlogService.getBlogComments(blogPostId)
		.then(function(response){
			$scope.blogComments=response.data;
		},function(response){
			console.log(response.status);
		})
	}
	$scope.updateApproval=function(){
		BlogService.updateApproval($scope.blogPost)
		.then(function(response){
			console.log(response.status)
			$location.path("/getAllBlogs")
		},function(response){
			console.log(response.status)
			$location.path("/BlogForApproval")
		})
	}
})
