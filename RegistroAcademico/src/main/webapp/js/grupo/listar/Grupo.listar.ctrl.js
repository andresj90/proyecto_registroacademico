var GrupoModule = angular.module('GrupoModule');

GrupoModule.controller('listarGrupoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        
        $scope.grupos = new Array();
        console.log($scope.grupos);
        $http.get('api/grupos').then(function (response) {
            console.log(response);
            $scope.grupos = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminarGrupo = function (id) {
            $http.delete('api/grupos/' + id).then(function (response) {
                // Recargar la vista 
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);