angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/market/api/v1/products'

    $scope.loadPage = function (pageIndex = 1) {
        $http({
            url: contextPath,
            method: 'GET',
            params: {
                'p': pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.products = response.data;
            $scope.navList = $scope.generatePagesIndexes(1, $scope.products.totalPages);
        });
    };


    $scope.deleteProduct = function (id){
        $http({
            url: 'http://localhost:8080/market/api/v1/products/' + id,
            method: 'Delete',
            params: {},
        }).then(function (response) {
            alert('product was delete');
            $scope.loadPage();
        });

    }

    $scope.showProductInfo = function (productIndex) {
        $http({
            url: 'http://localhost:8080/market/api/v1/products/' + productIndex,
            method: 'GET'
        }).then(function (response) {
            alert(response.data.title);
        });
    };

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.loadPage();
});