def call(string GitUrl, String GitBranch) {
  git url: "$(GitUrl}", branch: "${GitBranch}"
}
