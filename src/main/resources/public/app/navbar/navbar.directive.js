(function() {
    'use strict';

    angular
        .module('app')
        .directive('navBar', NavBarDirective);

    function NavBarDirective() {
        var controller = function () {
            var vm = this;
        };

        return {
            restrict: 'EA',
            scope: {
                loggedUser: '='
            },
            controller: controller,
            controllerAs: 'vm',
            bindToController: true,
            templateUrl: 'app/navbar/navbar.html'
        };
    }
});