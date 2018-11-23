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
                   controller: 'horarioCtrl'
               }
           }
        });
        

        
        $stateProvider.state("listarHorarios", {
           url: '/horariolist' ,
           views:{
               mainView: {
                   templateUrl: 'js/horario/listar/ListarHorario.html',
                   controller: 'listarHorarioCtrl'
               }
           }
        });
        
        
        $stateProvider.state("editarHorarios", {
           url: '/horarios/:id' ,
           views: {
               
               mainView :{
                  templateUrl: 'js/horario/crearActualizar/CrearHorario.html',
                  controller : 'horarioCtrl' 
               
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
        $stateProvider.state("editarTipoCurso", {
           url: '/tipoCurso/:id' ,
           views: {
               
               mainView :{
                  templateUrl: 'js/tipoCurso/crearActualizar/CrearTipoCurso.html',
                  controller : 'crearTipoCursoCtrl' 
               
               }
           }
            
        }); 
        
        $stateProvider.state("listarCurso", {
           url: '/listarCurso' ,
           views:{
               mainView: {
                   templateUrl: 'js/curso/listar/ListarCurso.html',
                   controller: 'listarCursoCtrl'
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
        $stateProvider.state("listarCursoGrupo", {
           url: '/listarCursoGrupo' ,
           views:{
               mainView: {
                   templateUrl: 'js/cursoGrupo/listar/ListarCursoGrupo.html',
                   controller: 'listarCursoGrupoCtrl'
               }
           }
        });
        
        $stateProvider.state("crearActualizarCursoGrupo", {
           url: '/CursoGrupo' ,
           views:{
               mainView: {
                   templateUrl: 'js/cursoGrupo/crearActualizar/CrearCursoGrupo.html',
                   controller: 'crearCursoGrupoCtrl'
               }
           }
        });
        $stateProvider.state("crearActualizarGrupo", {
           url: '/grupo' ,
           views:{
               mainView: {
                   templateUrl: 'js/grupo/crearActualizar/CrearGrupo.html',
                   controller: 'crearGrupoCtrl'
               }
           }
        });
        
        $stateProvider.state("listarGrupo", {
           url: '/listarGrupo' ,
           views:{
               mainView: {
                   templateUrl: 'js/grupo/listar/ListarGrupo.html',
                   controller: 'listarGrupoCtrl'
               }
           }
        });
        $stateProvider.state("editarGrupo", {
           url: '/grupo/:id' ,
           views: {
               
               mainView :{
                  templateUrl: 'js/grupo/crearActualizar/CrearGrupo.html',
                  controller : 'crearGrupoCtrl' 
               }
           }
            
        }); 
}]); 