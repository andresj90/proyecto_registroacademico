var CursoModule = angular.module('CursoModule');

CursoModule.controller('listarCursoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        $scope.cursos = new Array();
        console.log($scope.cursos);
        $http.get('api/cursos').then(function (response) {
            console.log(response);
            $scope.cursos = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminarCurso = function (id) {
            $http.delete('api/cursos/' + id).then(function (response) {
                // Recargar la vista 
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);