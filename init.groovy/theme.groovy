theme_css = 'https://cdn.rawgit.com/afonsof/jenkins-material-theme/gh-pages/dist/material-light-blue.css'

println "theme.groovy"

def set_simple_theme() {
  println '\t Set Simple Theme'
  for (pd in hudson.model.PageDecorator.all()) {
    if (pd instanceof org.codefirst.SimpleThemeDecorator) {
      println "\t\t Setting theme to ${theme_css}"
      pd.cssUrl = theme_css
    }
  }
}

set_simple_theme()
