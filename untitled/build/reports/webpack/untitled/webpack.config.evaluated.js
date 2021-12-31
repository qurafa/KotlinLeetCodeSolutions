{
  mode: 'development',
  resolve: {
    modules: [
      'node_modules'
    ]
  },
  plugins: [
    ProgressPlugin {
      profile: false,
      handler: [Function: handler],
      modulesCount: 500,
      showEntries: false,
      showModules: true,
      showActiveModules: true
    },
    TeamCityErrorPlugin {}
  ],
  module: {
    rules: [
      {
        test: /\.js$/,
        use: [
          'source-map-loader'
        ],
        enforce: 'pre'
      }
    ]
  },
  entry: {
    main: [
      '/Users/faruq/Library/Mobile Documents/com~apple~CloudDocs/GitHub/KotlinLeetCodeSolutions/KotlinLeetCodeSolutions/untitled/build/js/packages/untitled/kotlin/untitled.js'
    ]
  },
  output: {
    path: '/Users/faruq/Library/Mobile Documents/com~apple~CloudDocs/GitHub/KotlinLeetCodeSolutions/KotlinLeetCodeSolutions/untitled/build/distributions',
    filename: [Function: filename],
    library: 'untitled',
    libraryTarget: 'umd',
    globalObject: 'this'
  },
  devtool: 'eval-source-map',
  stats: {
    warningsFilter: [
      /Failed to parse source map/
    ],
    warnings: false,
    errors: false
  },
  devServer: {
    open: true,
    contentBase: [
      '/Users/faruq/Library/Mobile Documents/com~apple~CloudDocs/GitHub/KotlinLeetCodeSolutions/KotlinLeetCodeSolutions/untitled/build/processedResources/js/main'
    ]
  }
}