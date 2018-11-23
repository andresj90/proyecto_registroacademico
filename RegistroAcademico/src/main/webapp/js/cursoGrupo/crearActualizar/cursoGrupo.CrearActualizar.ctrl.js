/* global cursoGrupo */

var CursoGrupoModule = angular.module('CursoGrupoModule');

CursoGrupoModule.controller('crearCursoGrupoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;
        
       $scope.convertirAPalabra = function (dato){
                
                return dato.toString();
       }


        $scope.cursoGrupo = {};

        if (id) {
            $http.get('api/cursogrupos/' + id).then(function (response) {
                $scope.cursoGrupo = response.data;
            }, function (error) {
                console.log(error);
            });
        }

        $scope.crearCursoGrupo = function () {
            if ($scope.cursoGrupo.cursoIdCur && $scope.cursoGrupo.grupoIdGr && $scope.cursoGrupo.docenteIdGr  && $scope.cursoGrupo.tipoCursoId && $scope.cursoGrupo.cupoGrupo) {
                $http.post('api/cursogrupos', JSON.stringify($scope.cursoGrupo)).then(function (response) {
                    //Reinicia la vaariable
                    $scope.cursoGrupo = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarCurso');
                }, function (error) {
                    console.log(error);
                });
            }
        };
        
        $scope.actualizarCursoGrupo = function(){
            if ($scope.cursoGrupo.cursoIdCur && $scope.cursoGrupo.grupoIdGr && $scope.cursoGrupo.docenteIdGr  && $scope.cursoGrupo.tipoCursoId && $scope.cursoGrupo.cupoGrupo) {
                $http.put('api/cursogrupos/'+id, JSON.stringify($scope.cursoGrupo)).then(function(response){
                    //Reinicia la vaariable
                    $scope.cursoGrupo = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarCurso');
                }, function(error){
                    console.log(error);
                });
            }
        };
    }]);


