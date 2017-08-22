app.factory('userService', function($http) {
	console.log('instantiating userService.js');

	var BASE_URL = "http://localhost:7779/CollaborationBackend/"

	var userService = this;
    
	userService.createUser = function(user) {
		console.log('entering create user in service')
		return $http.post(BASE_URL + "/user/register", user).then(
				function(response) {
					console.log('creating user')
					console.log('Status :' + response.status)
					return response.data
				}, function(errResponse) {

					console.log('Error while creating user')
					return response.data
				});
	};

	return userService;

});

