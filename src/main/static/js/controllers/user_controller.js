/**
 * Created by John Lazaro on 16/06/2017.
 */
'use strict';

angular.module('app').controller('UserController', ['$scope', 'UserService', function($scope, UserService){
    var self = this;
    self.user={id:null,userPass:'',givenName:'',email:'',address:'',gender:'',contact:''};
    self.users=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    getAllUsers();

    function getAllUsers(){
        UserService.getAllUsers()
            .then(
                function(d){
                    self.users = d;
                },
                function(errResponse){
                    console.error('Error getting Users');
                }
            );

    }

    function createUser(user) {
        UserService.createUser(user)
            .then(
                getAllUsers,
                function(errResponse){
                        console.error('Error updating');
                }

                );
    }

    function updateUser(user, id){
        UserService.updateUser(id)
            .then(
                getAllUsers,
                function(errResponse){
                    console.error('Error')
                }
            );

    }

    function getUserById(id){
        UserService.getUserById(id)
            .then(
                getAllUsers,
                function(errResponse){
                    console.error('fucnked up son')
                }
            )
    }

    function submit(){
        // todo: validation
        if(!userPass || !givenName || !email|| !address || !gender || !contact){
            console.log("Empty Fields")
        }
        else{
            console.log('Creating User', self.user);
            createUser(user);
        }
        reset();
    }
    
    function reset(){
    self.user={id:null,userPass:'',givenName:'',email:'',address:'',gender:'',contact:''};
    $scope.myForm.$setPristine();
    }


}]);