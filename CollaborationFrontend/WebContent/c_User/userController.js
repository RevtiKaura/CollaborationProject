app.controller('userController',function($scope, userService, $http, $rootScope, $location,$cookies) {
  console.log('instantiating controller');

					$scope.user = {
						uName : '',
						fName : '',
						lName : '',
						password : '',
						dob:'',
						emailId : '',
						phoneNo : '',
						gen:'',
						address : '',
						role : '',
						isOnline : '',
						status : ''
					};

					$scope.users;

						$scope.createUser = function(user) {
						console.log('entering create user in controller')
						userService.createUser(user)
						.then(function(response) 
								{
								 console.log('registered Successfully'+ response.status)
								 $scope.user = {};
								 $scope.user.errorMessage = "Registered Successfully";
								 $location.path("/login")
								},function(error) {
											console.error('Error while creating user')
											$scope.user = {};
											$scope.user.errorMessage = "Error while creating user please try again";
											$location.path("/register")
										});
					};

					$scope.submit = function() {
						{
							console.log('Saving New User', $scope.user);
							$scope.createUser($scope.user);
						}

					};

	
							$scope.reset = function() {
								$scope.user = {
										uName : '',
										fName : '',
										lName : '',
										password : '',
										dob:'',
										emailId : '',
										phoneNo : '',
										gen:'',
										address : '',
										role : '',
										isOnline : '',
										status : ''
									};

						$scope.myForm.$setPristine();
					};
				})