var ProgramaoModule = angular.module('ProgramaModule');

ProgramaModule.controller('listarProgramaCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        $scope.Programas = new Array();
        console.log($scope.Programas);
        $http.get('api/programas').then(function (response) {
            console.log(response);
            $scope.Programas = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminarPrograma = function (id) {
            $http.delete('api/programas/' + id).then(function (response) {
                // Recargar la vista 
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);