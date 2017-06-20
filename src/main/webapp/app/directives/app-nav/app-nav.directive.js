(function() {
    angular
        .module('app')
        .directive('appNav', AppNavDirective);

    function AppNavDirective() {
        return {
            restrict: 'E',
            controller: 'AppNavController',
            controllerAs: 'vm',
            bindToController: true,
            templateUrl: 'app/directives/app-nav/app-nav.html'
        }
    }
})();