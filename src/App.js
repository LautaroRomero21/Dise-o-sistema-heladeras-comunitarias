import React, { useState, useEffect, useRef } from 'react';
import { BrowserRouter as Router, Route, Routes, useLocation } from 'react-router-dom';
import NavApp from './components/NavApp';
import HeaderApp from './components/HeaderApp';
import MapApp from './components/MapApp';
import ReportIssuePage from './pages/ReportIssuePage.js';
import ConsultaCanjePage from './pages/ConsultaCanjePage.js';
import PublicarProductoPage from './pages/PublicarProductoPage.js';
import RegistrarVulnerable from './pages/RegistrarVulnerablePage.js';
import InfoApp from './components/InfoApp';

function App() {
  const [headerHeight, setHeaderHeight] = useState(0);

  return (
    <Router>
      <NavApp />
      <Main setHeaderHeight={setHeaderHeight} headerHeight={headerHeight} />
    </Router>
  );
}

function Main({ setHeaderHeight, headerHeight }) {
  const location = useLocation();
  const isMapPage = location.pathname === '/map';
  const infoRef = useRef(null);

  const [isVisible, setIsVisible] = useState(false);

  useEffect(() => {
    const observer = new IntersectionObserver(
      ([entry]) => {
        if (entry.isIntersecting) {
          setIsVisible(true);
        }
      },
      { threshold: 0.1 }
    );

    if (infoRef.current) {
      observer.observe(infoRef.current);
    }

    return () => {
      if (infoRef.current) {
        observer.unobserve(infoRef.current);
      }
    };
  }, []);

  return (
    <>
      <NavApp className={isMapPage ? 'map-page' : ''} />
      {location.pathname === '/' && (
        <div className="header-info-container">
          <HeaderApp setHeaderHeight={setHeaderHeight} />
          <div ref={infoRef}>
            <InfoApp isVisible={isVisible} />
          </div>
        </div>
      )}
      <Routes>
        <Route path="/" element={<></>} />
        <Route path="/map" element={<MapApp />} />
        <Route path="/report-issue" element={<ReportIssuePage />} />
        <Route path="/consulta-canje" element={<ConsultaCanjePage />} />
        <Route path="/publicar-producto" element={<PublicarProductoPage />} />
        <Route path="/registro-vulnerable" element={<RegistrarVulnerable />} />
      </Routes>
    </>
  );
}

export default App;
