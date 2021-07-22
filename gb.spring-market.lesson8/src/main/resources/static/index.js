angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http({
            url: 'http://localhost:8080/market/products',
            method: 'GET',
            params: {}
        }).then(function (response) {
            console.log(response);
            $scope.products = response.data;
        });
    };

    // $scope.loadPage = function (pageIndex = 1) {
    //     $http({
    //         url: 'http://localhost:8080/market/products_page',
    //         method: 'GET',
    //         params: {
    //             'p': pageIndex
    //         }
    //     }).then(function (response) {
    //         console.log(response);
    //     });
    // };
    //
    // $scope.counterValue = 1;

    $scope.clickIncrementButton = function () {
        $scope.counterValue += 1;
    };

    $scope.deleteProduct = function (id){
        $http({
            url: 'http://localhost:8080/market/delete/' + id,
            method: 'GET'
        });
        $scope.loadProducts();
    }

    $scope.showProductInfo = function (productIndex) {
        $http({
            url: 'http://localhost:8080/market/info/' + productIndex,
            method: 'GET'
        }).then(function (response) {
            alert(response.data.title);
        });
    };

    $scope.loadProducts();
});