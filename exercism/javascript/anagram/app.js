require.config({
  shim: {
    underscore: {
      exports: '_'
    },
    backbone: {
      deps: ["underscore", "jquery"],
      exports: "Backbone"
    }
  }
});

//the "main" function to bootstrap your code
require(['jquery', 'underscore', 'backbone'], function ($, _, Backbone) {   // or, you could use these deps in a separate module using define

});