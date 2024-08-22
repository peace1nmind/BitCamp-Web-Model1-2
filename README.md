servlet mapping 으로 / 에 대한 접근을 logon으로 보낼 수도 있지만
모든 jsp에서 조건문으로 session.isNew()를 사용해 logon으로 sendRedirect 할 수 있다.
모든 파일이 jsp라면 어떤 걸 누르든 첫 파일에서만 session이 새로 생기고 그 이후는 기존 session을 가져오게 되기 때문
