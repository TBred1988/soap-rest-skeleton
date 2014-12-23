<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertAttribute name="taglibs" />
<!DOCTYPE html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/homepage.css">
    <script type="text/javascript" src="/resources/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/main.js"></script>
</head>
<body>
    <header>
        <tiles:insertAttribute name="header" />
    </header>
    <section>
        <div class="span-content">
            <tiles:insertAttribute name="content" />
        </div>
        <div class="span-side">
            <sidebar>
                <tiles:insertAttribute name="side" />
            </sidebar>
        </div>
    </section>
    <footer>
        <tiles:insertAttribute name="footer" />
    </footer>
</body>
</html>