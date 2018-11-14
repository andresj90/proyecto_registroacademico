/* global tipocurso */

var TipoCursoModule = angular.module('TipoCursoModule');

TipoCursoModule.controller('crearTipoCursoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;
        
       $scope.convertirAPalabra = function (dato){
                
                return dato.toString();
       }


        $scope.tipoCurso = {};

        if (id) {
            $http.get('api/tipocursos/' + id).then(function (response) {
                $scope.tipoCurso = response.data;
            }, function (error) {
                console.log(error);
            });
        }

        $scope.crearTipoCurso = function () {
            console.log($scope.tipoCurso);
            if ($scope.tipoCurso.nombreTipoCurso) {
                $http.post('api/tipocursos', JSON.stringify($scope.tipoCurso)).then(function (response) {
                    console.log(response.data);
                    //Reinicia la vaariable
                    $scope.tipoCurso = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarTipoCurso');
                }, function (error) {
                    console.log(error);
                });
            }
        };
        
        $scope.actualizarTipoCurso = function(){
            if ($scope.tipoCurso.nombre) {
                $http.put('api/tipocursos/'+id, JSON.stringify($scope.tipoCurso)).then(function(response){
                    //Reinicia la vaariable
                    $scope.tipoCurso = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarTipoCurso');
                }, function(error){
                    console.log(error);
                });
            }
        };
    }]);


