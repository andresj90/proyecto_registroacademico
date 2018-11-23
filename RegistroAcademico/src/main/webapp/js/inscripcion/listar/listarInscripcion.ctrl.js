var InscripcionModule = angular.module('InscripcionModule');

InscripcionModule.controller('listarInscripcionCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        $scope.Inscripciones = new Array();
        console.log($scope.inscripciones);
        $http.get('api/inscripciones').then(function (response) {
            console.log(response);
            $scope.Inscripciones = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminarInscripcion = function (id) {
            $http.delete('api/inscripciones/' + id).then(function (response) {
                // Recargar la vista 
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);