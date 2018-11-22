var app = angular.module('RegistroAcademico');

app.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) { 
       
        //Otherwise - control 404
        $urlRouterProvider.otherwise('/');
        
        //Por cada ruta se crea un nuevo estado
        
 
        
         $stateProvider.state("crearActualizarHorario", {
           url: '/horario' ,
           views:{
               mainView: {
                   templateUrl: 'js/horario/crearActualizar/CrearHorario.html',
                   controller: 'crearHorarioCtrl'
               }
           }
        });

         $stateProvider.state("crearActualizarTipoCurso", {
           url: '/tipoCurso' ,
           views:{
               mainView: {
                   templateUrl: 'js/tipoCurso/crearActualizar/CrearTipoCurso.html',
                   controller: 'crearTipoCursoCtrl'
               }
           }
        });
        
        $stateProvider.state("listarTipoCurso", {
           url: '/listarTipoCurso' ,
           views:{
               mainView: {
                   templateUrl: 'js/tipoCurso/listar/ListarTipoCurso.html',
                   controller: 'listarTipoCursoCtrl'
               }
           }
        });
        
        $stateProvider.state("listarCurso", {
           url: '/listarCurso' ,
           views:{
               mainView: {
                   templateUrl: 'js/curso/listar/ListarCurso.html',
                   controller: 'listarTipoCursoCtrl'
               }
           }
        });
        
        $stateProvider.state("crearActualizarCurso", {
           url: '/Curso' ,
           views:{
               mainView: {
                   templateUrl: 'js/curso/crearActualizar/CrearCurso.html',
                   controller: 'crearCursoCtrl'
               }
           }
        });
}]); 