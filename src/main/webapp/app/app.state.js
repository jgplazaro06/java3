(function() {
    'use strict';

    angular
        .module('app', ['ui.router'])
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
                params: {
                    returnUrl: null
                }
            })
            .state('register', {
                url: '/register',
                templateUrl: 'app/templates/register.html'
            })
            .state('error', {
                url: '/error',
                templateUrl: 'app/templates/error.html'
            })
            .state('cart', {
                url: '/cart',
                templateUrl: 'app/templates/cart.html'
            })
            .state('checkout', {
                url: '/checkout',
                templateUrl: 'app/templates/checkout.html'
            })
            .state('account', {
                url: '/account',
                templateUrl: 'app/templates/account.html'
            })
            .state('account-update', {
                url: '/account/update',
                templateUrl: 'app/templates/account-update.html'
            })
            .state('branch', {
                url: '/branch',
                templateUrl: 'app/templates/branch.html'
            });
    }
})();