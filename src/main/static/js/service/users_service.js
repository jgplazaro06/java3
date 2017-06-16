/**
 * Created by John Lazaro on 16/06/2017.
 */
'use strict';

angular.module('app').factory('UserService', ['$http', '$a', function ($http, a) {

    var service_url = 'http://localhost:8080/users/';

    var factory = {
        getAllUsers: getAllUsers,
        getUserById: getUserById,
        updateUser: updateUser,
        createUser: createUser
    }

    return factory;

    function getAllUsers() {
        var deff = $a.defer();
        $http.get(service_url)
            .then(
                function(response){
                    deff.resolve(response.data);
                },
                function (errResponse) {
                    deff.reject(errResponse)
                }
            );
        return deff.promise;
        
    }

    function getUserById() {
        var deff = $a.defer();
        $http.get(service_url + id)
            .then(
                function(response){
                    deff.resolve(response.data);
                },
                function(errResponse){
                    deff.reject(errResponse)
                }
            );
        return deff.promise;

    }

    function createUser(user){
        var deff = $a.defer();
        $http.post(service_url + "create", user)
            .then(
                function(response){
                    defer.resolve(response.data);
                },
                function(errResponse){
                    defer.reject(errResponse);
                }
            );
        return deff.promise;
    }

    function updateUser(user, id, newPass){
        var deff = $a.defer();
        $http.put(service_url + "update/" + id + "/" + newPass, user)
            .then(
                function(response){
                    defer.resolve(response.data);
                },
                function (errResponse) {
                    defer.reject(errResponse);
                    
                }
            );
        return deff.promise;

    }
    
}])