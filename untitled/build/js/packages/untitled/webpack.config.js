let config = {
  mode: 'development',
  resolve: {
    modules: [
      "node_modules"
    ]
  },
  plugins: [],
  module: {
    rules: []
  }
};

// entry
config.entry = {
    main: ["/Users/faruq/Library/Mobile Documents/com~apple~CloudDocs/GitHub/KotlinLeetCodeSolutions/KotlinLeetCodeSolutions/untitled/build/js/packages/untitled/kotlin/untitled.js"]
};

config.output = {
    path: "/Users/faruq/Library/Mobile Documents/com~apple~CloudDocs/GitHub/KotlinLeetCodeSolutions/KotlinLeetCodeSolutions/untitled/build/distributions",
    filename: (chunkData) => {
        return chunkData.chunk.name === 'main'
            ? "untitled.js"
            : "untitled-[name].js";
    },
    library: "untitled",
    libraryTarget: "umd",
    globalObject: "this"
};

// source maps
config.module.rules.push({
        test: /\.js$/,
        use: ["source-map-loader"],
        enforce: "pre"
});
config.devtool = 'eval-source-map';

config.stats = config.stats || {}
Object.assign(config.stats, config.stats, {
    warningsFilter: [/Failed to parse source map/]
})


// dev server
config.devServer = {
  "open": true,
  "contentBase": [
    "/Users/faruq/Library/Mobile Documents/com~apple~CloudDocs/GitHub/KotlinLeetCodeSolutions/KotlinLeetCodeSolutions/untitled/build/processedResources/js/main"
  ]
};

// Report progress to console
// noinspection JSUnnecessarySemicolon
;(function(config) {
    const webpack = require('webpack');
    const handler = (percentage, message, ...args) => {
        const p = percentage * 100;
        let msg = `${Math.trunc(p / 10)}${Math.trunc(p % 10)}% ${message} ${args.join(' ')}`;
        msg = msg.replace("/Users/faruq/Library/Mobile Documents/com~apple~CloudDocs/GitHub/KotlinLeetCodeSolutions/KotlinLeetCodeSolutions/untitled/build/js", '');;
        console.log(msg);
    };

    config.plugins.push(new webpack.ProgressPlugin(handler))
})(config);

// noinspection JSUnnecessarySemicolon
;(function(config) {
    const tcErrorPlugin = require('kotlin-test-js-runner/tc-log-error-webpack');
    config.plugins.push(new tcErrorPlugin())
    config.stats = config.stats || {}
    Object.assign(config.stats, config.stats, {
        warnings: false,
        errors: false
    })
})(config);
// save evaluated config file
;(function(config) {
    const util = require('util');
    const fs = require('fs');
    const evaluatedConfig = util.inspect(config, {showHidden: false, depth: null, compact: false});
    fs.writeFile("/Users/faruq/Library/Mobile Documents/com~apple~CloudDocs/GitHub/KotlinLeetCodeSolutions/KotlinLeetCodeSolutions/untitled/build/reports/webpack/untitled/webpack.config.evaluated.js", evaluatedConfig, function (err) {});
})(config);

module.exports = config
