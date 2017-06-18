(function() {
    'use strict';

    angular
        .module('app')
        .config(StateConfig);

    function StateConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'app/templates/home.html'
            })
            .state('login', {
                url: '/login',
                templateUrl: 'app/templates/login.html',
                controller: 'LoginController',
                controllerAs: 'vm',
                params: {
                    returnUrl: null
                }
            })
            .state('register', {
                url: '/register',
                templateUrl: 'app/templates/register.html',
                controller: 'RegisterController',
                controllerAs: 'vm',
                params: {
                    returnUrl: null
                }
            })
            .state('error', {
                url: '/error',
                templateUrl: 'app/templates/error.html'
            })
            .state('cart', {
                url: '/cart',
                templateUrl: 'app/templates/cart.html',
                controller: 'CartController',
                controllerAs: 'vm'
            })
            .state('checkout', {
                url: '/checkout',
                templateUrl: 'app/templates/checkout.html'
            })
            .state('account', {
                url: '/account',
                templateUrl: 'app/templates/account.html',
                controller: 'AccountController',
                controllerAs: 'vm',
                params: {
                    isPasswordChangeSuccessful: null,
                    isEmailChangeSuccessful: null
                }
            })
            .state('password-update', {
                url: '/account/update/password',
                templateUrl: 'app/templates/password-update.html',
                controller: 'PasswordUpdateController',
                controllerAs: 'vm'
            })
            .state('branch', {
                url: '/branch',
                templateUrl: 'app/templates/branch.html'
            });
    }
})();