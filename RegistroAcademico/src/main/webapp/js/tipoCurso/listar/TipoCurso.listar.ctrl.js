var TipoCursoModule = angular.module('TipoCursoModule');

TipoCursoModule.controller('listarTipoCursoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        $scope.tipoCursos = new Array();
        console.log($scope.tipoCursos);
        $http.get('api/tipocursos').then(function (response) {
            console.log(response);
            $scope.tipoCursos = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminarTipoCurso = function (id) {
            $http.delete('api/tipocursos/' + id).then(function (response) {
                // Recargar la vista 
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);