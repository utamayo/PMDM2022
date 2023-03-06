import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';

const MAPBOX_ACCESS_TOKEN =
    'pk.eyJ1IjoiY2VxdWUiLCJhIjoiY2tkM3F4MzV1MHl4NjJ0bndzdWdmNWI5cSJ9._jBKVgTDTR2W1auJYOgiMg';

final plazaDelTorico = LatLng(40.34284844766679, -1.1071225108944662);

class MapPage extends StatelessWidget {
  const MapPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mapbox Mapa'),
        centerTitle: true,
        backgroundColor: Colors.blueAccent,
      ),
      body: FlutterMap(
        options: MapOptions(
          center: plazaDelTorico,
          minZoom: 7.0,
          maxZoom: 19.0,
          zoom: 14.0,
        ),
        nonRotatedChildren: [
          TileLayer(
              urlTemplate: 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
              userAgentPackageName: 'dev.fleaflet.flutter_map.example',
              additionalOptions: const {
                'accessToken': MAPBOX_ACCESS_TOKEN,
                'id': 'mapbox/streets-v12'
              }),
          MarkerLayer(
            markers: [
              Marker(
                  point: plazaDelTorico,
                  builder: (context) {
                    return Container(
                      child: const Icon(
                        Icons.person_pin,
                        color: Colors.blueAccent,
                        size: 40,
                      ),
                    );
                  }),
            ],
          )
        ],
      ),
    );
  }
}
