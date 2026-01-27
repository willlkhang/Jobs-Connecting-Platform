import "./styles/global.scss";
import "./styles/main.scss";

import Header from "./components/header/Header";
import Footer from "./components/footer/Footer";

export default function RootLayout({ 
  children, 
}: Readonly <{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>
        
        <div className="main-layout">
          <Header />
          {children}
          <Footer />
        </div>
        
      </body>
    </html>
  );
}