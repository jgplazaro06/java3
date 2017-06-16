/**
 * Created by John Lazaro on 17/06/2017.
 */
var routerApp = angular.module('routerApp', ['ui.router']);

routerApp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/login');

    $stateProvider


        //generic error page
        //links back to home page of either customer or employee
        .state('error',{
            url:'/error',
            templateUrl: 'error.html'
        })

        .state('login',{
            url:'/login',
            templateUrl: 'loginPage.html'
        })

        //takes input for new user
        .state('register', {
            url: '/register',
            templateUrl:'register.html'
        })

        // //sends to db
        // .state('registerSuccess', {
        //     url: '/register/' + newpass + '/' + givenName + '/' + email + '/' + address + '/' + gender + '/' + contact + '/' + 0,
        //     templateUrl: 'registerSuccess.html'
        // })


        //home customer
            //if logged in is customer(role = 0)

        //basically product page
        //problem is paging
        .state('home', {
        url: '/home',
        templateUrl: 'home.html'
        })

        //cart
        //gets all cartproducts where cartId = current
        .state('cart',{
            url:'/cart',
            templateUrl: 'cart.html'
        })

        //gets the current cartsid where userid = logged in and status = 0
        //shows cartsproducts where cartid = above
        .state('checkout', {
            url: '/checkout/:userId',
            templateUrl: 'checkout.html'
        })

    //     //change status of cart id to 1
    //     .state('checkoutFinal',{
    //         url: '/checkout/success',
    //         templateUrl: 'checkoutSucess.html'
    // })

        //gets account details of current logged in user
        // has change password button leads to update
        .state('account',{
            url:'/myaccount/:id',
            templateUrl: 'myAccount.html'
        })

        //takes input for old pass and new pass
        .state('update',{
            url:'/myaccount/update',
            templateUrl: 'update.html'

        })

        // //passess old and new
        // //if success send to home
        // .state('updateaccount', {
        //     url:'/update/' + id + '/' + newPass,
        //     templateUrl: 'updateAccount.html'
        // })

    //home employee
            //if logged in is employee(role = 1)


        //gets all cartsids where branchid = loggedin and status = 1
        //just shows cartproducts of all cartids above
        .state('branchcart',{
            url: '/employee/' + branchId + '/' + 1,
            templateUrl: 'branchCart.html'
        })

        //sales view; gets cartids of all cart where branch id = logged in and status  = 2
        //displays cart products of all returned cartids
        //rofl fuckthisshitsomebodysaveme
        //no actions can de done here pleasenomore
        //problem is paging
        .state('branchsales', {
            url:'/employee/sales/' + branchId,
            templateUrl: 'branchSales.html'
        })

        //update view.. has text box to input productid...
        .state('branchupdate',{
            url:'/employee/update',
            templateUrl: 'branchUpdate.html'
        })


        // //shows returned product
        // //takes input for quantity to be added
        // .state('branchupdateitem',{
        //     url:'/employee/update/' + productId,
        //     templateUrl: 'updateItem.html'
        // })
        //
        // //updates db accordingly <-wowengland
        // .state('updateItem', {
        //     url:'/employee/update/' + productId + '/' + quantity,
        //     templateUrl: 'updateSucess.html'
        //
        // })


    //still need transaction table?
    //no?
    //probably no
});