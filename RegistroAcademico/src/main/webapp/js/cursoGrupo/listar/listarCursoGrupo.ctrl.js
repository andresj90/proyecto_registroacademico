var CursoGrupoModule = angular.module('CursoGrupoModule');

CursoGrupoModule.controller('listarCursoGrupoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        $scope.cursoGrupos = new Array();
        console.log($scope.cursoGrupos);
        $http.get('api/cursogrupos').then(function (response) {
            console.log(response);
            $scope.cursoGrupos = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminarCursoGrupo = function (id) {
            $http.delete('api/cursogrupos/' + id).then(function (response) {
                // Recargar la vista 
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);